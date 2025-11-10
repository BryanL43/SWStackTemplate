import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'

const enableStrict = import.meta.env.VITE_STRICT_MODE === 'true'

createRoot(document.getElementById('root')!).render(
    // Enable strict mode for dev purposes.
    // Strict mode causes double rendering on components.
    enableStrict ? (
        <StrictMode>
            <App />
        </StrictMode>
    ) : (
        <App />
    )
)
